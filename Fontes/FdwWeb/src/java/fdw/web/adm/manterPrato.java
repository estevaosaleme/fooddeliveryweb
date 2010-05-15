/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.web.adm;

import br.com.fdw.negocio.entidades.Cardapio;
import br.com.fdw.negocio.entidades.Prato;
import br.com.fdw.negocio.fachada.ManterCardapio;
import br.com.fdw.negocio.fachada.ManterPrato;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fdw.web.SessionBean1;
import fdw.web.RequestBean1;
import fdw.web.ApplicationBean1;
import java.util.List;
import javax.faces.event.ValueChangeEvent;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version manterPrato.java
 * @version Created on 21/03/2010, 15:02:17
 * @author pedro
 */

public class manterPrato extends AbstractPageBean {
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
    public manterPrato() {
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
            log("manterPrato Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        atualizaLista();
        getRequestBean1().setCardapioTemporario("");
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
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }
    
	private void limparCamposFormulario() {
        getRequestBean1().setPrato(new Prato());
        getRequestBean1().setCardapioTemporario("");
        getSessionBean1().setImagemTemp(null);
    }

    private String atualizaLista(){
        try {
            ManterPrato facade = new ManterPrato();
            List pratos = facade.listarPratos();
            getSessionBean1().getPratoProvider().setList(pratos);
        } catch (Exception e) {
            error(e.getMessage());
        }
            return null;
    }
    public String hlkPrato_action() {
        try {
            int selecionado = Integer.parseInt(getValue("#{currentRow.value['codigoPrato']}").toString());
            ManterPrato manterprato = new ManterPrato();
            Prato prato = manterprato.consultarPrato(selecionado);
            getRequestBean1().setCardapioTemporario(prato.getCardapio().getCodigoCardapio().toString());
            getRequestBean1().setPrato(prato);
            getSessionBean1().setImagemTemp(getRequestBean1().getPrato().getFoto());
        }
        catch (Exception e) {
                error(e.getMessage());
        }
       return null;
    }

    public String btnLimpar_action() {
        limparCamposFormulario();
        return null;
    }

    public String btnSalvarNovo_action() {
        try {
            Prato prato = getRequestBean1().getPrato();
            ManterPrato facade = new ManterPrato();
            prato.setFoto(getFoto());
            facade.incluirPrato(prato);
            info("Registro inserido com sucesso!");
            limparCamposFormulario();
            return atualizaLista();
        } catch (Exception e) {
            error(e.getMessage());
        }
         return null;
    }

    public String btnAtualizar_action() {
        try {
            Prato prato = getRequestBean1().getPrato();
            ManterPrato facade = new ManterPrato();
            prato.setFoto(getFoto());
            facade.atualizarPrato(prato);
            info("Registro atualizado com sucesso!");
            limparCamposFormulario();
            return atualizaLista();
        } catch (Exception e) {
            error(e.getMessage());
        }
        return null;
    }

    public String btnExcluir_action() {
        try {
            Prato prato = getRequestBean1().getPrato();
            ManterPrato facade = new ManterPrato();
            facade.excluirPrato(prato.getCodigoPrato());
            info("Registro excluído com sucesso!");
            limparCamposFormulario();
            return atualizaLista();
        } catch (Exception e) {
            error(e.getMessage());
        }
        return null;
    }

   public byte[] getFoto() {
       
       if(getRequestBean1().getUploadedFile() != null && getRequestBean1().getUploadedFile().getBytes().length != 0 )
       {
           byte[] foto = getRequestBean1().getUploadedFile().getBytes();
           if (!getRequestBean1().getUploadedFile().getOriginalName().toUpperCase().contains("JPG"))
           {
               info("Apenas imagens JPG são aceitas.");
               return null;
           }
           return foto;
       }
       return null;
    }


   public void txtcardapio_processValueChange(ValueChangeEvent event) {
        String codCard = (String) event.getNewValue();
        getSessionBean1().setImagemTemp(getRequestBean1().getPrato().getFoto());
        if (!codCard.equals(""))
        {
            int card = Integer.parseInt(codCard);
            ManterCardapio facade = new ManterCardapio();
            Cardapio objCard = facade.listarCardapio(card);
            try {
                if (objCard == null || objCard.getCodigoCardapio() == null)
                    info("Cardápio inválido, não exite cadastrado");
                else
                    getRequestBean1().getPrato().setCardapio(objCard);
            }
            catch (Exception e)
            {
                info("Falha ao recuperar cardápio");
            }
        }
        getSessionBean1().setImagemTemp(getRequestBean1().getPrato().getFoto());
   }
}

