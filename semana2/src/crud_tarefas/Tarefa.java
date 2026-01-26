package crud_tarefas;

import java.util.*;

public class Tarefa {
	Random generator = new Random();
	
	protected String titulo;
	protected Long id;

	
	
	public Tarefa(String titulo, Long id) {
		this.titulo = titulo;
		this.id = id;
	}
	
	public Long gerarId() {
		id = generator.nextLong(100)+1;
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
