package de.ait.fitlio.service;

import de.ait.fitlio.dto.FitlioDto;
import de.ait.fitlio.dto.NewFitlioDto;

import java.util.List;

public interface FitlioService {
    FitlioDto addFitlio(NewFitlioDto newFitlio);

    List<FitlioDto> getAllFitlio();

    //найти тренировку
    FitlioDto getFitlioById(Long fitlioId);

    //обновить тренировку
    FitlioDto updateFitlioById(Long fitlioId);

    //удалить
}
