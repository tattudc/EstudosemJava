package tads.eaj.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import tads.eaj.aula.model.Emprestimos;
import tads.eaj.aula.model.Enderecos;
import tads.eaj.aula.model.Livros;
import tads.eaj.aula.model.Usuarios;
import tads.eaj.aula.repository.*;


import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class RunMyCode implements ApplicationRunner {

    @Autowired
    LivrosRepository livrosRepository;
    @Autowired
    EmprestimosRepository emprestimosRepository;
    @Autowired
    UsuariosRepository usuariosRepository;
    @Autowired
    EnderecosRepository enderecosRepository;

    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {

		/*
		Usuarios c1 = new Usuarios();
		Enderecos e1 = new Enderecos();
		c1.setNome("Jose");
		c1.setIdade(34);
		e1.setRua("Quinho");
		e1.setNumero(15);

		c1.setEnderecos(e1);
		e1.setUsuarios(c1);
		enderecosRepository.save(e1);


		//Usuários e Emprestimos
		Usuarios c2 = new Usuarios();
		c2.setNome("João");
		Enderecos e2 = new Enderecos();
		e2.setRua("Lagoa");
		c2.setEnderecos(e2);
		e2.setUsuarios(c2);

		Emprestimos p1 = new Emprestimos();
		Emprestimos p2 = new Emprestimos();
		Emprestimos p3 = new Emprestimos();
		p1.setDataEmprestimo("0101");
		p1.setQuantidade("1");
		p2.setDataEmprestimo("0201");
        p2.setQuantidade("2");
		p3.setDataEmprestimo("0301");
        p3.setQuantidade("4");

		List<Emprestimos> emprestimos = new ArrayList<>();
		emprestimos.add(p1);
		emprestimos.add(p2);
		emprestimos.add(p3);
		c2.setEmprestimos(emprestimos);

		//clienteRepository.save(c1);
		p1.setUsuarios(c2);
		p2.setUsuarios(c2);
		p3.setUsuarios(c2);
		usuariosRepository.save(c2);
		//pedidoRepository.save(p2);
		//pedidoRepository.save(p3);
		//c1.setPedidos(pedidos);



        //fetch tests
        Usuarios c3 = usuariosRepository.getOne((long) 2);
        System.out.println(c3.getNome());
        System.out.println(c3.getEnderecos().getRua());
        //System.out.println(c1.getPedidos().get(1).toString());


		//Many to Many
		Usuarios c4 = new Usuarios();
		c4.setNome("Pedro");
		Enderecos e4 = new Enderecos();
		e4.setRua("jundiai");
		c4.setEnderecos(e4);
		e4.setUsuarios(c4);
		Emprestimos o = new Emprestimos();
		o.setDataEmprestimo("hoje");
		List<Emprestimos> emprestimosList = new ArrayList<>();
		emprestimosList.add(o);
		o.setUsuarios(c4);
		c4.setEmprestimos(emprestimosList);
		Livros l1 = new Livros();
		Livros l2 = new Livros();
		Livros l3 = new Livros();
		l1.setTitulo("Livro 1");
		l2.setTitulo("Livro 2");
		l3.setTitulo("Livro 3");
		l1.setEmprestimos(emprestimosList);
		l2.setEmprestimos(emprestimosList);
		l3.setEmprestimos(emprestimosList);
		List<Livros> livrosList = new ArrayList<>();
		livrosList.add(l1);
		livrosList.add(l2);
		livrosList.add(l3);
		o.setLivros(livrosList);
		usuariosRepository.save(c4);*/

    }
}
