package com.jo.cscinfdel.controller;

import com.jo.cscinfdel.model.QTipoVia;
import com.jo.cscinfdel.model.TipoVia;
import com.jo.cscinfdel.repository.TipoViaRepository;
import com.querydsl.core.types.Predicate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/TipoVia")
public class TipoViaController {

    @Autowired
    private TipoViaRepository repository;

    @RequestMapping(value = "/read-all", method = RequestMethod.GET)
    public List<TipoVia> readAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody TipoVia object) {
        repository.delete(object);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public TipoVia create(@RequestBody TipoVia object) {

        return repository.save(object);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public TipoVia update(@RequestBody TipoVia object) {


        return repository.save(object);
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor()
    public static class RequestBody4GetByPageAndFilter {
        Integer pageNumber = 0;
        Integer pageSize = 1;
        String filter = "";
    }


    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor()
    public static class ResponseBody4GetByPageAndFilter {
        Long totalCount;
        List<TipoVia> items;
    }

    @RequestMapping(value = "/get-by-page-and-filter", method = RequestMethod.POST)
    public ResponseBody4GetByPageAndFilter getByPageAndFilter(@RequestBody RequestBody4GetByPageAndFilter requestBody) {

        QTipoVia qTipoVia = QTipoVia.tipoVia;


        String filter = requestBody.filter;
        if (filter == null) {
            filter = "";
        }

        Predicate predicate = qTipoVia.descripcion.containsIgnoreCase(filter);

        PageRequest pageRequest = PageRequest.of(requestBody.pageNumber, requestBody.pageSize);

        Long totalCount = repository.count(predicate);
        List<TipoVia> items = repository.findAll(predicate, pageRequest)
                .getContent();

        return new ResponseBody4GetByPageAndFilter(totalCount, items);

    }
}

