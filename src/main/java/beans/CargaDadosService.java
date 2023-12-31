/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package beans;

import gestaoProcessos.Prova;
import gestaoProcessos.Edital;
import gestaoProcessos.Inscricao;
import gestaoProcessos.ProcessoSeletivo;
import gestaoProcessos.Arquivo;
import gestaoProcessos.Categoria;
import gestaoProcessos.Publicacao;
import gestaoProcessos.TipoUsuario;
import gestaoProcessos.Usuario;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Rian Alves Leal <ral2 at ifnmg.edu.br>
 */
@Singleton
@Startup
public class CargaDadosService {

    @Inject
    private UsuarioServiceLocal usuarioBean;
    
    @Inject
    private ProvaSessionServiceLocal provaBean;
    
    @Inject
    private EditalServiceLocal editalBean;
    
    @Inject
    private ParticipacaoServiceLocal participacaoBean;
    
    @Inject
    private ProcessoSeletivoServiceLocal processoBean;
    
    @Inject
    private PublicacaoServiceLocal publicacaoBean;
    
    @Inject
    private ArquivoServiceLocal arquivoBean;
    
    @PostConstruct
    public void PopularAdm(){
        
        ProcessoSeletivo processo = new ProcessoSeletivo();
        
        
//        Prova provaDia1 = new Prova();
//        provaDia1.setCor("azul");
//        provaDia1.setData(LocalDate.of(2023, 11, 5));
//        provaDia1.setDia((short)1);
//        Prova provaDia2 = new Prova();
//        provaDia2.setCor("amarelo");
//        provaDia2.setData(LocalDate.of(2023, 11, 12));
//        provaDia2.setDia((short)2);
//        
//        Edital edital = new Edital();
//        edital.setData(LocalDate.of(2023, 8, 23));
//        edital.setDescricao("O PRESIDENTE DO INSTITUTO NACIONAL DE ESTUDOS E PESQUISAS EDUCACIONAIS ANÍSIO TEIXEIRA -INEP, no uso das suas atribuições, em cumprimento aos dispositivos da Chamada Pública nº 43, de 19 de Junho de 2023, torna pública a relação, em ordem alfabética dos interessados confirmados/não confirmados e dos convocados para o curso de capacitação na modalidade a distância que atenderam integralmente aos requisitos estabelecidos no item 3 do Edital de Chamada Pública, disponível no endereço eletrônico: http://certificadores.inep.gov.br/");
//        edital.setNumero(59);
        
        Edital edital = new Edital();
        edital.setData(LocalDate.of(2023, 8, 23));
        edital.setDescricao("O PRESIDENTE DO INSTITUTO NACIONAL DE ESTUDOS E PESQUISAS EDUCACIONAIS ANÍSIO TEIXEIRA -INEP, no uso das suas atribuições, em cumprimento aos dispositivos da Chamada Pública nº 43, de 19 de Junho de 2023, torna pública a relação, em ordem alfabética dos interessados confirmados/não confirmados e dos convocados para o curso de capacitação na modalidade a distância que atenderam integralmente aos requisitos estabelecidos no item 3 do Edital de Chamada Pública, disponível no endereço eletrônico: http://certificadores.inep.gov.br/");
        edital.setNumero(59);
        
        Inscricao participacao = new Inscricao();
        participacao.setProcessoSeletivo(processo);
        
        processo.setAberto(Boolean.TRUE);
        processo.getCandidatos().add(participacao);
        processo.setDescricao("descricao");
        processo.setEdital(edital);
        
        Publicacao publicacao = new Publicacao();
        publicacao.setConteudo("O PRESIDENTE DO INSTITUTO NACIONAL DE ESTUDOS E PESQUISAS EDUCACIONAIS ANÍSIO TEIXEIRA -INEP, no uso das suas atribuições, em cumprimento aos dispositivos da Chamada Pública nº 43, de 19 de Junho de 2023, torna pública a relação, em ordem alfabética dos interessados confirmados/não confirmados e dos convocados para o curso de capacitação na modalidade a distância que atenderam integralmente aos requisitos estabelecidos no item 3 do Edital de Chamada Pública, disponível no endereço eletrônico: http://certificadores.inep.gov.br/");
        publicacao.setCreatedAt(LocalDateTime.now());
        publicacao.setEdital(edital);
//        publicacao.setProva(provaDia1);
        publicacao.setTitulo("Edital para prova do dia 1");
        publicacao.setUpdatedAt(LocalDateTime.now());
        publicacao.setCategoria(Categoria.NOTICIA);
        
        Arquivo arquivo = new Arquivo();
        arquivo.setNome("Edital numero 59");
        
//        provaBean.salvar(provaDia1);
        
        editalBean.salvar(edital);
        
        participacaoBean.salvar(participacao);
//        Inscricao participacao = new Inscricao();;
//        participacao.setProcessoSeletivo(processo);
//        
//        processo.setAberto(Boolean.TRUE);
//        processo.getCandidatos().add(participacao);
//        processo.setDescricao("descricao");
//        processo.setEdital(edital);

        
//        Publicacao publicacao = new Publicacao();
//        publicacao.setConteudo("O PRESIDENTE DO INSTITUTO NACIONAL DE ESTUDOS E PESQUISAS EDUCACIONAIS ANÍSIO TEIXEIRA -INEP, no uso das suas atribuições, em cumprimento aos dispositivos da Chamada Pública nº 43, de 19 de Junho de 2023, torna pública a relação, em ordem alfabética dos interessados confirmados/não confirmados e dos convocados para o curso de capacitação na modalidade a distância que atenderam integralmente aos requisitos estabelecidos no item 3 do Edital de Chamada Pública, disponível no endereço eletrônico: http://certificadores.inep.gov.br/");
//        publicacao.setCreatedAt(LocalDateTime.now());
//        publicacao.setEdital(edital);
//        publicacao.setProva(provaDia1);
//        publicacao.setTitulo("Edital para prova do dia 1");
//        publicacao.setUpdatedAt(LocalDateTime.now());
//        
//        Arquivo arquivo = new Arquivo();
//        arquivo.setNome("Edital numero 59");
//        
//        provaBean.salvar(provaDia1);
//        
//        editalBean.salvar(edital);
//        
//        participacaoBean.salvar(participacao);
//        
        processoBean.salvar(processo);
        
//        publicacaoBean.salvar(publicacao);
//        
//        arquivoBean.salvar(arquivo);
        
        Usuario usuario = new Usuario();
        usuario.setAtivo(Boolean.TRUE);
        usuario.setNome("G");
        usuario.setCpf("12345678901");
        usuario.setEmail("gabrielsizilio1@gmail.com");
        usuario.setKey(UUID.randomUUID());
        usuario.setReceberNoticia(Boolean.TRUE);
        usuario.setSenha("123");
        usuario.setTipo(TipoUsuario.ADMINISTRADOR);
        
        Usuario candidato = new Usuario("Rian", "98765432199", "rian@mail.com", "123", 
                Boolean.TRUE, TipoUsuario.EDITOR, Boolean.TRUE);
        
        Usuario editora = new Usuario("Yodemis", "54312387612", "yjsn@aluno.ifnmg.edu.br", "123", 
                Boolean.TRUE, TipoUsuario.CANDIDATO, Boolean.TRUE);
        editora.setKey(UUID.randomUUID());
        
        usuarioBean.salvar(usuario);
        usuarioBean.salvar(candidato);
        usuarioBean.salvar(editora);
    }
}
