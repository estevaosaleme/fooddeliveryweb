/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fdw.web;

import br.com.fdw.negocio.entidades.Prato;
import br.com.fdw.negocio.fachada.ManterCliente;
import br.com.fdw.negocio.fachada.ManterEstabelecimento;
import br.com.fdw.negocio.fachada.ManterPrato;
import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.model.OptionsList;
import fdw.web.optionlist.estabelecimentoOptionsList;
import fdw.web.portal.Carrinho;
import javax.faces.FacesException;
import fdw.web.provider.*;
import java.util.List;
import java.util.Random;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 *
 * @version SessionBean1.java
 * @version Created on 18/03/2010, 21:09:25
 * @author pedro
 */
public class SessionBean1 extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    // </editor-fold>
    private cepProvider CepProvider;
    private cardapioProvider CardapioProvider;
    private clienteProvider ClienteProvider;
    private estabelecimentoProvider EstabelecimentoProvider;
    private formasPagamentoProvider FormasPagamentoProvider;
    private pedidoProvider PedidoProvider;
    private pratoProvider PratoProvider;
    private estabelecimentoOptionsList EstabelecimentoOptionsList;
    private OptionsList SexoOptionsList;
    private OptionsList EstadoOptionsList;
    private byte[] ImagemTemp;
    private int UsuarioLogado;
    private String mensagemUsuario;
    private Carrinho carrinhoCompras;
    private int detalhePrato;

    private Prato prato1;
    private Prato prato2;
    private Prato prato3;
    private Prato prato4;
    private Prato prato5;
    private Prato prato6;

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SessionBean1() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     * 
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
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
            log("SessionBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here

        setCepProvider(new cepProvider());
        setCardapioProvider(new cardapioProvider());
        setClienteProvider(new clienteProvider());
        setEstabelecimentoProvider(new estabelecimentoProvider());
        setFormasPagamentoProvider(new formasPagamentoProvider());
        setPedidoProvider(new pedidoProvider());
        setPratoProvider(new pratoProvider());

        setEstabelecimentoOptionsList(new estabelecimentoOptionsList());
        setEstadoOptionsList(new OptionsList());
        setSexoOptionsList(new OptionsList());

        CarregaListas();
        setCarrinhoCompras(new Carrinho());

        setaPratosHome();
    }

    private void setaPratosHome() {
        ManterPrato facade = new ManterPrato();
        List<Prato> lstPrato = facade.listarPratos();
        if (lstPrato.size() <= 0)
        {
            Prato fake = new Prato();
            fake.setCodigoPrato(0);
            fake.setNomePrato("Nenhum prato cadastrado");
            fake.setValorUnitario(0);
            setPrato1(fake);
            setPrato2(fake);
            setPrato3(fake);
            setPrato4(fake);
            setPrato5(fake);
            setPrato6(fake);
        }
        Random rd = new Random();
        int item1 = rd.nextInt(lstPrato.size());
        setPrato1(lstPrato.get(item1));
        int item2 = rd.nextInt(lstPrato.size());
        setPrato2(lstPrato.get(item2));
        int item3 = rd.nextInt(lstPrato.size());
        setPrato3(lstPrato.get(item3));
        int item4 = rd.nextInt(lstPrato.size());
        setPrato4(lstPrato.get(item4));
        int item5 = rd.nextInt(lstPrato.size());
        setPrato5(lstPrato.get(item5));
        int item6 = rd.nextInt(lstPrato.size());
        setPrato6(lstPrato.get(item6));
    }

    private void CarregaListas() {
        ManterEstabelecimento facade = new ManterEstabelecimento();
        getEstabelecimentoOptionsList().setList(facade.listarEstabelecimentos());

        Option[] lstSexo = {new Option('M'), new Option('F')};
        getSexoOptionsList().setOptions(lstSexo);

        Option[] lstEstado = {new Option("SP"), new Option("MG"), new Option("RJ")};
        getEstadoOptionsList().setOptions(lstEstado);
    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     * 
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    @Override
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     * 
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    @Override
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     * 
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    public cepProvider getCepProvider() {
        return CepProvider;
    }

    public void setCepProvider(cepProvider CepProvider) {
        this.CepProvider = CepProvider;
    }

    /**
     * @return the CardapioProvider
     */
    public cardapioProvider getCardapioProvider() {
        return CardapioProvider;
    }

    /**
     * @param CardapioProvider the CardapioProvider to set
     */
    public void setCardapioProvider(cardapioProvider CardapioProvider) {
        this.CardapioProvider = CardapioProvider;
    }

    /**
     * @return the ClienteProvider
     */
    public clienteProvider getClienteProvider() {
        return ClienteProvider;
    }

    /**
     * @param ClienteProvider the ClienteProvider to set
     */
    public void setClienteProvider(clienteProvider ClienteProvider) {
        this.ClienteProvider = ClienteProvider;
    }

    /**
     * @return the EstabelecimentoProvider
     */
    public estabelecimentoProvider getEstabelecimentoProvider() {
        return EstabelecimentoProvider;
    }

    /**
     * @param EstabelecimentoProvider the EstabelecimentoProvider to set
     */
    public void setEstabelecimentoProvider(estabelecimentoProvider EstabelecimentoProvider) {
        this.EstabelecimentoProvider = EstabelecimentoProvider;
    }

    /**
     * @return the FormasPagamentoProvider
     */
    public formasPagamentoProvider getFormasPagamentoProvider() {
        return FormasPagamentoProvider;
    }

    /**
     * @param FormasPagamentoProvider the FormasPagamentoProvider to set
     */
    public void setFormasPagamentoProvider(formasPagamentoProvider FormasPagamentoProvider) {
        this.FormasPagamentoProvider = FormasPagamentoProvider;
    }

    /**
     * @return the PedidoProvider
     */
    public pedidoProvider getPedidoProvider() {
        return PedidoProvider;
    }

    /**
     * @param PedidoProvider the PedidoProvider to set
     */
    public void setPedidoProvider(pedidoProvider PedidoProvider) {
        this.PedidoProvider = PedidoProvider;
    }

    /**
     * @return the PratoProvider
     */
    public pratoProvider getPratoProvider() {
        return PratoProvider;
    }

    /**
     * @param PratoProvider the PratoProvider to set
     */
    public void setPratoProvider(pratoProvider PratoProvider) {
        this.PratoProvider = PratoProvider;
    }

    /**
     * @return the EstabelecimentoOptionsList
     */
    public estabelecimentoOptionsList getEstabelecimentoOptionsList() {
        return EstabelecimentoOptionsList;
    }

    /**
     * @param EstabelecimentoOptionsList the EstabelecimentoOptionsList to set
     */
    public void setEstabelecimentoOptionsList(estabelecimentoOptionsList EstabelecimentoOptionsList) {
        this.EstabelecimentoOptionsList = EstabelecimentoOptionsList;
    }

    /**
     * @return the SexoOptionsList
     */
    public OptionsList getSexoOptionsList() {
        return SexoOptionsList;
    }

    /**
     * @param SexoOptionsList the SexoOptionsList to set
     */
    public void setSexoOptionsList(OptionsList SexoOptionsList) {
        this.SexoOptionsList = SexoOptionsList;
    }

    /**
     * @return the EstadoOptionsList
     */
    public OptionsList getEstadoOptionsList() {
        return EstadoOptionsList;
    }

    /**
     * @param EstadoOptionsList the EstadoOptionsList to set
     */
    public void setEstadoOptionsList(OptionsList EstadoOptionsList) {
        this.EstadoOptionsList = EstadoOptionsList;
    }

    /**
     * @return the ImagemTemp
     */
    public byte[] getImagemTemp() {
        return ImagemTemp;
    }

    /**
     * @param ImagemTemp the ImagemTemp to set
     */
    public void setImagemTemp(byte[] ImagemTemp) {
        this.ImagemTemp = ImagemTemp;
    }

    /**
     * @return the UsuarioLogado
     */
    public int getUsuarioLogado() {
        return UsuarioLogado;
    }

    /**
     * @param UsuarioLogado the UsuarioLogado to set
     */
    public void setUsuarioLogado(int UsuarioLogado) {
        this.UsuarioLogado = UsuarioLogado;
        if (this.getUsuarioLogado() > 0)
        {
            ManterCliente facade = new ManterCliente();
            setMensagemUsuario("Olá "+facade.listarCliente(UsuarioLogado).getNomeCliente()+". Logout");
        }
        else
            setMensagemUsuario("");
    }

    /**
     * @return the mensagemUsuario
     */
    public String getMensagemUsuario() {
        return mensagemUsuario;
    }

    /**
     * @param mensagemUsuario the mensagemUsuario to set
     */
    public void setMensagemUsuario(String mensagemUsuario) {
        this.mensagemUsuario = mensagemUsuario;
    }

    /**
     * @return the carrinhoCompras
     */
    public Carrinho getCarrinhoCompras() {
        return carrinhoCompras;
    }

    /**
     * @param carrinhoCompras the carrinhoCompras to set
     */
    public void setCarrinhoCompras(Carrinho carrinhoCompras) {
        this.carrinhoCompras = carrinhoCompras;
    }

    /**
     * @return the detalhePrato
     */
    public int getDetalhePrato() {
        return detalhePrato;
    }

    /**
     * @param detalhePrato the detalhePrato to set
     */
    public void setDetalhePrato(int detalhePrato) {
        this.detalhePrato = detalhePrato;
    }

    /**
     * @return the prato1
     */
    public Prato getPrato1() {
        return prato1;
    }

    /**
     * @param prato1 the prato1 to set
     */
    public void setPrato1(Prato prato1) {
        this.prato1 = prato1;
    }

    /**
     * @return the prato2
     */
    public Prato getPrato2() {
        return prato2;
    }

    /**
     * @param prato2 the prato2 to set
     */
    public void setPrato2(Prato prato2) {
        this.prato2 = prato2;
    }

    /**
     * @return the prato3
     */
    public Prato getPrato3() {
        return prato3;
    }

    /**
     * @param prato3 the prato3 to set
     */
    public void setPrato3(Prato prato3) {
        this.prato3 = prato3;
    }

    /**
     * @return the prato4
     */
    public Prato getPrato4() {
        return prato4;
    }

    /**
     * @param prato4 the prato4 to set
     */
    public void setPrato4(Prato prato4) {
        this.prato4 = prato4;
    }

    /**
     * @return the prato5
     */
    public Prato getPrato5() {
        return prato5;
    }

    /**
     * @param prato5 the prato5 to set
     */
    public void setPrato5(Prato prato5) {
        this.prato5 = prato5;
    }

    /**
     * @return the prato6
     */
    public Prato getPrato6() {
        return prato6;
    }

    /**
     * @param prato6 the prato6 to set
     */
    public void setPrato6(Prato prato6) {
        this.prato6 = prato6;
    }

}
