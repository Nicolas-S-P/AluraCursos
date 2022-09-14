package com.example.demo.service

import com.example.demo.dto.AtualizacaoExtracaoForm
import com.example.demo.dto.NovaExtracaoForm
import com.example.demo.dto.ExtracaoPorNomeDto
import com.example.demo.dto.ExtracaoView
import com.example.demo.exception.NotFoundException
import com.example.demo.mapper.ExtracaoFormMapper
import com.example.demo.mapper.ExtracaoViewMapper
import com.example.demo.repository.ExtracaoRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import javax.persistence.EntityManager

@Service
class ExtracaoService(
    private val repository: ExtracaoRepository,
    private val extracaoViewMapper: ExtracaoViewMapper,
    private val extracaoFormMapper: ExtracaoFormMapper,
    private val notFoundMessage: String = "Extracao nao encontrada!",
    private val em: EntityManager
) {

    fun listar(
        nomeMinerio: String?,
        paginacao: Pageable
    ): Page<ExtracaoView> {
        print(em)
        val extracoes = if (nomeMinerio == null) {
            repository.findAll(paginacao)
        } else {
            repository.findByMinerioNome(nomeMinerio, paginacao)
        }
        return extracoes.map { t ->
            extracaoViewMapper.map(t)
        }
    }

    fun buscarPorId(id: Long): ExtracaoView {
        val extracao = repository.findById(id)
                .orElseThrow{ NotFoundException(notFoundMessage) }
        return extracaoViewMapper.map(extracao)
    }

    fun cadastrar(form: NovaExtracaoForm): ExtracaoView {
        val extracao = extracaoFormMapper.map(form)
        repository.save(extracao)
        return extracaoViewMapper.map(extracao)
    }

    fun atualizar(form: AtualizacaoExtracaoForm): ExtracaoView {
        val extracao = repository.findById(form.id)
                .orElseThrow{ NotFoundException(notFoundMessage) }
        extracao.titulo = form.titulo
        extracao.descricao = form.descricao
        return extracaoViewMapper.map(extracao)
    }

    fun deletar(id: Long) {
        repository.deleteById(id)
    }

    fun relatorio(): List<ExtracaoPorNomeDto> {
        return repository.relatorio()
    }

}