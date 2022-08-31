package com.generation.blog.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.blog.Repository.PostRepository;
import com.generation.blog.model.Post;

@RestController
@RequestMapping("/postagens")
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class PostController {
    @Autowired
    private PostRepository postRepository;

    @GetMapping
    public ResponseEntity<List<Post>> getAll(){
        return ResponseEntity.ok(postRepository.findAll());
    }
    
    public ResponseEntity<Post> getById(@PathVariable Long id){
        return postRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta)).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/titulo{title}")
    public ResponseEntity<List<Post>> getByTitle(@PathVariable String title){
        return ResponseEntity.ok(postRepository.findAllByTitleContainingIgnoreCase(title));
    }
    @PostMapping
    public ResponseEntity<Post> post(@Valid @RequestBody Post post){
        return ResponseEntity.status(HttpStatus.CREATED).body(postRepository.save(post));
    }
    @PutMapping
    public ResponseEntity<Post> put(@Valid @RequestBody Post post){
        return postRepository.findById(post.getId()).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(postRepository.save(post))).orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        Optional<Post> post = postRepository.findById(id);
        if(post.isEmpty())
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        postRepository.deleteById(id);
    }


}
