/**
 * Loja.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package controle;

public class Loja  implements java.io.Serializable {
    private int codigo;

    private java.lang.String nick;

    private java.lang.String razaoSocial;

    private java.lang.String senha;

    public Loja() {
    }

    public Loja(
           int codigo,
           java.lang.String nick,
           java.lang.String razaoSocial,
           java.lang.String senha) {
           this.codigo = codigo;
           this.nick = nick;
           this.razaoSocial = razaoSocial;
           this.senha = senha;
    }


    /**
     * Gets the codigo value for this Loja.
     * 
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this Loja.
     * 
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the nick value for this Loja.
     * 
     * @return nick
     */
    public java.lang.String getNick() {
        return nick;
    }


    /**
     * Sets the nick value for this Loja.
     * 
     * @param nick
     */
    public void setNick(java.lang.String nick) {
        this.nick = nick;
    }


    /**
     * Gets the razaoSocial value for this Loja.
     * 
     * @return razaoSocial
     */
    public java.lang.String getRazaoSocial() {
        return razaoSocial;
    }


    /**
     * Sets the razaoSocial value for this Loja.
     * 
     * @param razaoSocial
     */
    public void setRazaoSocial(java.lang.String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }


    /**
     * Gets the senha value for this Loja.
     * 
     * @return senha
     */
    public java.lang.String getSenha() {
        return senha;
    }


    /**
     * Sets the senha value for this Loja.
     * 
     * @param senha
     */
    public void setSenha(java.lang.String senha) {
        this.senha = senha;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Loja)) return false;
        Loja other = (Loja) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.codigo == other.getCodigo() &&
            ((this.nick==null && other.getNick()==null) || 
             (this.nick!=null &&
              this.nick.equals(other.getNick()))) &&
            ((this.razaoSocial==null && other.getRazaoSocial()==null) || 
             (this.razaoSocial!=null &&
              this.razaoSocial.equals(other.getRazaoSocial()))) &&
            ((this.senha==null && other.getSenha()==null) || 
             (this.senha!=null &&
              this.senha.equals(other.getSenha())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCodigo();
        if (getNick() != null) {
            _hashCode += getNick().hashCode();
        }
        if (getRazaoSocial() != null) {
            _hashCode += getRazaoSocial().hashCode();
        }
        if (getSenha() != null) {
            _hashCode += getSenha().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Loja.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://controle/", "loja"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nick");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nick"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("razaoSocial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "razaoSocial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("senha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "senha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
