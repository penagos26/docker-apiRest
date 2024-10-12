package com.uptc.frw.lafabrica.controller;

import com.uptc.frw.lafabrica.model.BookMy;
import com.uptc.frw.lafabrica.service.BookMyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Libros", description = "Endpoints de libros")
@RequestMapping("/api/books")
public class BookMyController {

    private final BookMyService bookMyService;

    @Autowired
    public BookMyController(BookMyService bookMyService) {
        this.bookMyService = bookMyService;
    }

    @Operation(summary = "Obtener todos los libros",
            description = "Devuelve una lista de todos los libros disponibles.")
    @GetMapping
    public ResponseEntity<List<BookMy>> getAllBooks() {
        List<BookMy> books = bookMyService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @Operation(summary = "Obtener un libro por ID",
            description = "Devuelve un libro específico mediante su ID.",
            parameters = @Parameter(name = "id", description = "ID del libro a obtener", required = true))
    @GetMapping("/{id}")
    public ResponseEntity<BookMy> getBookById(@PathVariable Long id) {
        return bookMyService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un nuevo libro",
            description = "Crea un nuevo libro en la base de datos.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Detalles del libro a crear",
                    content = @Content(
                            schema = @Schema(implementation = BookMy.class)
                    )
            ))
    @PostMapping
    public ResponseEntity<BookMy> createBook(@RequestBody BookMy bookMy) {
        BookMy createdBook = bookMyService.createBook(bookMy);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @Operation(summary = "Actualizar un libro",
            description = "Actualiza los detalles de un libro existente.",
            parameters = @Parameter(name = "id", description = "ID del libro a actualizar", required = true),
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Detalles del libro a actualizar",
                    content = @Content(
                            schema = @Schema(implementation = BookMy.class)
                    )
            ))
    @PutMapping("/{id}")
    public ResponseEntity<BookMy> updateBook(@PathVariable Long id, @RequestBody BookMy bookMy) {
        return ResponseEntity.ok(bookMyService.updateBook(id, bookMy));
    }

    @Operation(summary = "Eliminar un libro",
            description = "Elimina un libro específico mediante su ID.",
            parameters = @Parameter(name = "id", description = "ID del libro a eliminar", required = true))
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookMyService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
