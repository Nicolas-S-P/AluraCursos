package com.example.demo.mapper

import com.example.demo.dto.NovaExtracaoForm
import com.example.demo.model.Extracao
import com.example.demo.service.MinerioService
import com.example.demo.service.AreaService
import org.springframework.stereotype.Component

@Component
class ExtracaoFormMapper(
    private val minerioService: MinerioService,
    private val areaService: AreaService
): Mapper<NovaExtracaoForm, Extracao> {
    override fun map(t: NovaExtracaoForm): Extracao {
        return Extracao(
                titulo = t.titulo,
                descricao = t.descricao,
                minerio = minerioService.buscarPorId(t.idMinerio),
                area = areaService.buscarPorId(t.idArea)
        )
    }
}
