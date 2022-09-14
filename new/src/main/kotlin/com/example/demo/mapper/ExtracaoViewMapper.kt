package com.example.demo.mapper

import com.example.demo.dto.ExtracaoView
import com.example.demo.model.Extracao
import org.springframework.stereotype.Component

@Component
class ExtracaoViewMapper: Mapper<Extracao, ExtracaoView> {

    override fun map(t: Extracao): ExtracaoView {
        return ExtracaoView(
                id = t.id,
                titulo = t.titulo,
                descricao = t.descricao,
                dataSolicitacao = t.dataSolicitacao,
                status = t.status
        )
    }
}