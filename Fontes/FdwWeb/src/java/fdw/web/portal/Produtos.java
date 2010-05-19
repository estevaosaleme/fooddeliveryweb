/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web.portal;

import br.com.fdw.negocio.entidades.Cardapio;
import br.com.fdw.negocio.entidades.Estabelecimento;
import br.com.fdw.negocio.entidades.Prato;
import br.com.fdw.negocio.fachada.ManterCardapio;
import br.com.fdw.negocio.fachada.ManterEstabelecimento;
import br.com.fdw.negocio.fachada.ManterPrato;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fdw.web.ApplicationBean1;
import fdw.web.RequestBean1;
import fdw.web.SessionBean1;
import java.util.List;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version Estabelecimentos.java
 * @version Created on 16/05/2010, 13:56:14
 * @author pedro
 */

public class Produtos extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Produtos() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
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
            log("Estabelecimentos Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        atualizaLista();
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    private String atualizaLista(){
        try {
            if (getSessionBean1().getEstabelecimentoProvider().getList() == null  || getSessionBean1().getEstabelecimentoProvider().getList().size() <= 0 || ((Estabelecimento)getSessionBean1().getEstabelecimentoProvider().getList().get(0)).getCodigoEstabelecimento() == null)
            {
                getSessionBean1().getEstabelecimentoProvider().getList().clear();
                getSessionBean1().getCardapioProvider().getList().clear();
                getSessionBean1().getPratoProvider().getList().clear();
                ManterEstabelecimento facade = new ManterEstabelecimento();
                List estabelecimentos = facade.listarEstabelecimentos();
                getSessionBean1().getEstabelecimentoProvider().setList(estabelecimentos);
            }
        } catch (Exception e) {
            error(e.getMessage());
        }
            return null;
    }

    public String hlkEstabelecimento_action() {
         try {
             getSessionBean1().getCardapioProvider().getList().clear();
             getSessionBean1().getPratoProvider().getList().clear();
            int selecionado = Integer.parseInt(getValue("#{currentRow.value['codigoEstabelecimento']}").toString());
            ManterCardapio facadeCardapio = new ManterCardapio();
            List<Cardapio> lstCardapio = facadeCardapio.listarByCodigoEstabelecimento(selecionado);

            if (lstCardapio.size() > 0)
            {
                getSessionBean1().getCardapioProvider().setList(lstCardapio);
                listaPratos(((Cardapio)lstCardapio.get(0)).getCodigoCardapio());
            }
        }
        catch (Exception e) {
                error(e.getMessage());
        }
       return null;
    }

     public String hlkPrato_action(){
        int selecionado = Integer.parseInt(getValue("#{currentRow.value['codigoPrato']}").toString());
        getSessionBean1().setDetalhePrato(selecionado);
        return "DetalhePrato";
     }

     public String hlkCardapio_action(){
         int selecionado = Integer.parseInt(getValue("#{currentRow.value['codigoCardapio']}").toString());
         listaPratos(selecionado);
         return null;
     }

    private void listaPratos(int codigoCardapio) {
        getSessionBean1().getPratoProvider().getList().clear();
        ManterPrato facadePrato = new ManterPrato();
        List<Prato> lstPrato = facadePrato.listarByCodigoCardapio(codigoCardapio);
        if (lstPrato.size() > 0)
            getSessionBean1().getPratoProvider().setList(lstPrato);
    }
}

