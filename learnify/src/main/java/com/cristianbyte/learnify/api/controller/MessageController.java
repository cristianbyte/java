package com.cristianbyte.learnify.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cristianbyte.learnify.api.dto.request.MessageRequest;
import com.cristianbyte.learnify.api.dto.response.MessageResponse;
import com.cristianbyte.learnify.infraestructure.abstract_service.IMessageService;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/message")
@AllArgsConstructor
@Tag(name = "Messages")
public class MessageController {
    @Autowired
    private final IMessageService messageService;

    @GetMapping
    public ResponseEntity<Page<MessageResponse>> getMessage(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size
    ) {
        return ResponseEntity.ok(this.messageService.getAll(page, size));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MessageResponse> getById(@PathVariable String id) {
        return ResponseEntity.ok(this.messageService.getById(id));
    }

    @PostMapping
    public ResponseEntity<MessageResponse> create(@Validated @RequestBody MessageRequest message) {
        return ResponseEntity.ok(this.messageService.create(message));
    }
}