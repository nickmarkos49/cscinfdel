package com.jo.cscinfdel.controller;

import com.jo.cscinfdel.model.QViolenciaIntraFamiliar;
import com.jo.cscinfdel.model.ViolenciaIntraFamiliar;
import com.jo.cscinfdel.repository.ViolenciaIntraFamiliarRepository;
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
@RequestMapping("/ViolenciaIntraFamiliar")
public class ViolenciaIntraFamiliarController {

    @Autowired
    private ViolenciaIntraFamiliarRepository repository;

    @RequestMapping(value = "/read-all", method = RequestMethod.GET)
    public List<ViolenciaIntraFamiliar> readAll() {
        return repository.findAll();
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody ViolenciaIntraFamiliar object) {
        repository.delete(object);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ViolenciaIntraFamiliar create(@RequestBody ViolenciaIntraFamiliar object) {

        return repository.save(object);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ViolenciaIntraFamiliar update(@RequestBody ViolenciaIntraFamiliar object) {

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
        List<ViolenciaIntraFamiliar> items;
    }

    @RequestMapping(value = "/get-by-page-and-filter", method = RequestMethod.POST)
    public ResponseBody4GetByPageAndFilter getByPageAndFilter(@RequestBody RequestBody4GetByPageAndFilter requestBody) {

        QViolenciaIntraFamiliar qViolenciaIntraFamiliar = QViolenciaIntraFamiliar.violenciaIntraFamiliar;


        String filter = requestBody.filter;
        if (filter == null) {
            filter = "";
        }

        Predicate predicate = qViolenciaIntraFamiliar.viCodigoSecuencial.containsIgnoreCase(filter);

        PageRequest pageRequest = PageRequest.of(requestBody.pageNumber, requestBody.pageSize);

        Long totalCount = repository.count(predicate);
        List<ViolenciaIntraFamiliar> items = repository.findAll(predicate, pageRequest)
                .getContent();

        return new ResponseBody4GetByPageAndFilter(totalCount, items);

    }

}
