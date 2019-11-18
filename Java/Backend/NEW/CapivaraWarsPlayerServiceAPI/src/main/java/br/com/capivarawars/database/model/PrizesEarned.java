package br.com.capivarawars.database.model;

// <editor-fold defaultstate="collapsed" desc="imports...">
import static br.com.capivarawars.endpoint.config.EndpointsMapping.*;
import br.com.capivarawars.database.repository.*;
import br.com.capivarawars.endpoint.client.*;
import br.com.capivarawars.endpoint.config.*;
import br.com.capivarawars.endpoint.handler.*;
import br.com.capivarawars.security.*;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.*;

import br.com.capivarawars.security.Cryptography;
import com.fasterxml.jackson.annotation.*;
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="documentation...">
/**
 * Objective: ...
 *
 * Description: ...
 *
 * @version 1.0.0
 * @author Tiago Penha Pedroso, 17/11/2019, 15:44:00 Last update: -
 */// </editor-fold>
@Entity
@Table(name = "PRIZES_EARNED")
public class PrizesEarned {

	// <editor-fold defaultstate="collapsed" desc="attributes...">
	// <editor-fold desc="DATABASE FIELDS..." defaultstate="collapsed">
	@Id
	@GeneratedValue
	@Column(name = "ID_PRIZES_EARNED")
	private Long idPrizesEarned;
	
	@Column(name = "PRIZE_DATETIME", columnDefinition = "DATETIME")
	private LocalDateTime prizeDateTime;
	// </editor-fold>	
	// <editor-fold desc="RELATIONSHIPS..." defaultstate="collapsed">	
	@ManyToOne
    @JoinColumn(name = "ID_PLAYER")
	private Player playerFK;

	@Column(name = "ID_PRIZE")
	private Long idPrize;
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="constants attributes...">	
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="static attributes...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="auxiliary attributes...">
	// </editor-fold>
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="constructors...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="methods...">
	// <editor-fold defaultstate="collapsed" desc="getter and setter methods...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="override methods...">	
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="auxiliary methods...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="static methods...">
	// </editor-fold>
	// <editor-fold defaultstate="collapsed" desc="main methods...">	
	// </editor-fold>
	// </editor-fold>
	
}//class
