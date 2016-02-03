package mx.ine.sscc.modelo.bean;

import java.io.Serializable;

/**
 * TODO [Agregar documentacion de la clase]
 * 
 * @author Orlando Adrián Ramos Galván (orlandoa.ramos@outlook.com)
 * @version 1.0
 * @since SIIRFE 5.10
 */
public class DatosRegistro implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long id;
	private Byte estatus;
	private String controlSinc;
	private String idTxt;
	private Long procesoSincronizacionId;

	/**
	 * TODO [Agregar documentacion al método]
	 * 
	 * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
	 */
	public DatosRegistro() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * TODO [Agregar documentacion al método]
	 * 
	 * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
	 * @param id
	 * @param estatus
	 */
	public DatosRegistro(Long id, Byte estatus, Long procesoSincronizacionId) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.estatus = estatus;
		this.procesoSincronizacionId = procesoSincronizacionId;
	}

	/**
	 * TODO [Agregar documentacion al método]
	 * 
	 * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
	 * @param id
	 * @param estatus
	 */
	public DatosRegistro(Long id, String controlSinc, Long procesoSincronizacionId) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.controlSinc = controlSinc;
		this.procesoSincronizacionId = procesoSincronizacionId;
	}

	/**
	 * TODO [Agregar documentacion al método]
	 * 
	 * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
	 * @param idTxt
	 * @param controlSinc
	 */
	public DatosRegistro(String idTxt, String controlSinc, Long procesoSincronizacionId) {
		// TODO Auto-generated constructor stub
		this.idTxt = idTxt;
		this.controlSinc = controlSinc;
		this.procesoSincronizacionId = procesoSincronizacionId;
	}

	/**
	 * TODO [Agregar documentacion al método]
	 * 
	 * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
	 * @return
	 */
	public Long getId() {
		return id;
	}

	/**
	 * TODO [Agregar documentacion al método]
	 * 
	 * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * TODO [Agregar documentacion al método]
	 * 
	 * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
	 * @return
	 */
	public Byte getEstatus() {
		return estatus;
	}

	/**
	 * TODO [Agregar documentacion al método]
	 * 
	 * @author Orlando Adrián Ramos Galván,(orlandoa.ramos@outlook.com)
	 * @param estatus
	 */
	public void setEstatus(Byte estatus) {
		this.estatus = estatus;
	}

	/**
	 * @return el atributo controlSinc
	 */

	public String getControlSinc() {
		return controlSinc;
	}

	/**
	 * @param controlSinc
	 *            parametro controlSinc a actualizar
	 */

	public void setControlSinc(String controlSinc) {
		this.controlSinc = controlSinc;
	}

	/**
	 * @return el atributo idTxt
	 */

	public String getIdTxt() {
		return idTxt;
	}

	/**
	 * @param idTxt
	 *            parametro idTxt a actualizar
	 */

	public void setIdTxt(String idTxt) {
		this.idTxt = idTxt;
	}

	/**
	 * @return el atributo procesoSincronizacionId
	 */
	public Long getProcesoSincronizacionId() {
		return procesoSincronizacionId;
	}

	/**
	 * @param procesoSincronizacionId
	 *            parametro procesoSincronizacionId a actualizar
	 */
	public void setProcesoSincronizacionId(Long procesoSincronizacionId) {
		this.procesoSincronizacionId = procesoSincronizacionId;
	}

}
