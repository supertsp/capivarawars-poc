package br.com.capivarawars.database.model;

//<editor-fold defaultstate="collapsed" desc="imports...">
import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.time.LocalDateTime;

import javax.persistence.*;
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 * 
 * Description: ...
 * 
 * @version 1.0.0
 * @author TPEDROSO, 23/10/2019, 13:11:44
 * Last update: -
 *///</editor-fold>
@Entity
@Table(name="CAPIVARA")
public class CapivaraDAO {
    
    //<editor-fold defaultstate="collapsed" desc="attributes...">
    
    //<editor-fold defaultstate="collapsed" desc="main attributes...">
    @Id
    @GeneratedValue
    @Column(name = "ID_CAPIVARA")
    private Long idCapivara;
    
    @Column(name = "NOME", length = VARCHAR_LENGTH_NOME)
    private String nome;
    
    @Column(name = "PASSWORD", length = VARCHAR_LENGTH_PASSWORD)
    private String password;
    
    @Column(name = "DATA_HORA_CRIACAO_CONTA", columnDefinition = "DATETIME")
    private LocalDateTime dataHoraCriacaoConta;
    
    @Column(name = "URL_FOTO", length = VARCHAR_LENGTH_URL_FOTO)
    private String urlFoto;
    
    @Column(name = "NOME_COMPLETO", length = VARCHAR_LENGTH_NOME_COMPLETO)
    private String nomeCompleto;
    
    @Column(name = "EMAIL", length = VARCHAR_LENGTH_EMAIL)
    private String email;
        
    @Column(name = "GENERO", length = CHAR_GENERO, columnDefinition = "CHAR")
    private Character genero;
    
    @Column(name = "DATA_NASCIMENTO", columnDefinition = "DATE")
    private LocalDate dataNascimento;
    
    @Column(name = "STATUS_ONLINE")
    private Boolean statusOnline;
    
    @Column(name = "ULTIMO_CODIGO_ATIVACAO", length = VARCHAR_LENGTH_ULTIMO_CODIGO_ATIVACAO)
    private String ultimoCodigoAtivacao;
    
    @Column(name = "VITORIAS")
    private Integer vitorias;
    
    @Column(name = "EMPATES")
    private Integer empates;
    
    @Column(name = "DERROTAS")
    private Integer derrotas;
    
    @Column(name = "MOEDAS")
    private Integer moedas;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constants attributes...">
    public static final int
            VARCHAR_LENGTH_NOME = 45;
            
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static attributes...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
    
    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="constructors...">
    public CapivaraDAO() {
        
    }
    
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="methods...">
    
    //<editor-fold defaultstate="collapsed" desc="getter and setter methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="override methods...">
    
    //</editor-fold>    
    
    //<editor-fold defaultstate="collapsed" desc="auxiliary methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="static methods...">
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="main methods...">
    
    //</editor-fold>
    
    //</editor-fold>
        
}//class
