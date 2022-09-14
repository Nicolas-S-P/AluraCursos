package com.example.demo.controller

import com.example.demo.dto.AtualizacaoExtracaoForm
import com.example.demo.dto.NovaExtracaoForm
import com.example.demo.dto.ExtracaoPorNomeDto
import com.example.demo.dto.ExtracaoView
import com.example.demo.service.ExtracaoService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import org.springframework.web.util.UriComponentsBuilder
import javax.validation.Valid

@RestController
@RequestMapping("/extracao")
class ExtracaoController(private val service: ExtracaoService) {

    @GetMapping
    @Cacheable("extracao")
    fun listar(
            @RequestParam(required = false) nomeMinerio: String?,
            @PageableDefault(size = 5, sort = ["dataSolicitacao"], direction = Sort.Direction.DESC) paginacao: Pageable
    ): Page<ExtracaoView> {
        return service.listar(nomeMinerio, paginacao)
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): ExtracaoView {
        return service.buscarPorId(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["extracao"], allEntries = true)
    fun cadastrar(
        @RequestBody @Valid form: NovaExtracaoForm,
        uriBuilder: UriComponentsBuilder
    ): ResponseEntity<ExtracaoView> {
        val extracaoView = service.cadastrar(form)
        val uri = uriBuilder.path("/extracoes/${extracaoView.id}").build().toUri()
        return ResponseEntity.created(uri).body(extracaoView)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["extracoes"], allEntries = true)
    fun atualizar(@RequestBody @Valid form: AtualizacaoExtracaoForm): ResponseEntity<ExtracaoView> {
        val extracaoView = service.atualizar(form)
        return ResponseEntity.ok(extracaoView)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict(value = ["extracoes"], allEntries = true)
    fun deletar(@PathVariable id: Long) {
        service.deletar(id)
    }

    @GetMapping("/relatorio")
    fun relatorio(): List<ExtracaoPorNomeDto> {
        return service.relatorio()
    }

}