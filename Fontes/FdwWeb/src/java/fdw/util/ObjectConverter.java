/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fdw.util;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author pedro
 */
public class ObjectConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
       return value.getBytes();
    }

    public String getAsString(FacesContext context, UIComponent component, Object value) {
       byte[] chegada = (byte[]) value;
       return new String(chegada);
    }
}
