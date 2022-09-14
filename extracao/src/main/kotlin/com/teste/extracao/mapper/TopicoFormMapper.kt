package com.teste.extracao.mapper

import com.teste.extracao.dto.NovoTopicoForm
import com.teste.extracao.model.Topico
import com.teste.extracao.service.CursoService
import com.teste.extracao.service.UsuarioService
import org.springframework.stereotype.Component

@Component
class TopicoFormMapper(
    private val cursoService: CursoService,
    private val usuarioService: UsuarioService
): Mapper<NovoTopicoForm, Topico> {
    override fun map(t: NovoTopicoForm): Topico {
        return Topico(
                titulo = t.titulo,
                mensagem = t.mensagem,
                curso = cursoService.buscarPorId(t.idCurso),
                autor = usuarioService.buscarPorId(t.idAutor)
        )
    }

}
