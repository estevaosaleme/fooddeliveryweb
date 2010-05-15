/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web;

import br.com.fdw.negocio.entidades.*;
import com.sun.rave.web.ui.appbase.AbstractRequestBean;
import com.sun.webui.jsf.model.UploadedFile;
import javax.faces.FacesException;

/**
 * <p>Request scope data bean for your application.  Create properties
 *  here to represent data that should be made available across different
 *  pages in the same HTTP request, so that the page bean classes do not
 *  have to be directly linked to each other.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version RequestBean1.java
 * @version Created on 18/03/2010, 21:09:25
 * @author pedro
 */

public class RequestBean1 extends AbstractRequestBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>

    private Cep cep;
    private Cardapio cardapio;
    private Cliente cliente;
    private Estabelecimento estabelecimento;
    private FormaPagamento formaPagamento;
    private Pedido pedido;
    private Prato prato;

    private String CepTemporario;
    private String CardapioTemporario;
    transient private UploadedFile uploadedFile;



    /**
     * <p>Construct a new request data bean instance.</p>
     */
    public RequestBean1() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * request scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * request scope.</p>
     * 
     * <p>You may customize this method to allocate resources that are required
     * for the lifetime of the current request.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("RequestBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        setCep(new Cep());
        setCardapio(new Cardapio());
        setCliente(new Cliente());
        setEstabelecimento(new Estabelecimento());
        setFormaPagamento(new FormaPagamento());
        setPedido(new Pedido());
        setPrato(new Prato());
    }

    /**
     * <p>This method is called when this bean is removed from
     * request scope.  This occurs automatically when the corresponding
     * HTTP response has been completed and sent to the client.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the request.</p>
     */
    @Override
    public void destroy() {
    }
    
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * @return the cep
     */
    public Cep getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(Cep cep) {
        this.cep = cep;
    }

    /**
     * @return the cardapio
     */
    public Cardapio getCardapio() {
        return cardapio;
    }

    /**
     * @param cardapio the cardapio to set
     */
    public void setCardapio(Cardapio cardapio) {
        this.cardapio = cardapio;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the estabelecimento
     */
    public Estabelecimento getEstabelecimento() {
        return estabelecimento;
    }

    /**
     * @param estabelecimento the estabelecimento to set
     */
    public void setEstabelecimento(Estabelecimento estabelecimento) {
        this.estabelecimento = estabelecimento;
    }

    /**
     * @return the formaPagamento
     */
    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the prato
     */
    public Prato getPrato() {
        return prato;
    }

    /**
     * @param prato the prato to set
     */
    public void setPrato(Prato prato) {
        this.prato = prato;
    }

     /**
     * @return the CepTemporario
     */
    public String getCepTemporario() {
        return CepTemporario;
    }

    /**
     * @param CepTemporario the CepTemporario to set
     */
    public void setCepTemporario(String CepTemporario) {
        this.CepTemporario = CepTemporario;
    }

    /**
     * @return the CardapioTemporario
     */
    public String getCardapioTemporario() {
        return CardapioTemporario;
    }

    /**
     * @param CardapioTemporario the CardapioTemporario to set
     */
    public void setCardapioTemporario(String CardapioTemporario) {
        this.CardapioTemporario = CardapioTemporario;
    }

    public UploadedFile getUploadedFile() {
        return this.uploadedFile;
    }
    public void setUploadedFile(UploadedFile uploadedFile) {
        this.uploadedFile = uploadedFile;
    }

}
