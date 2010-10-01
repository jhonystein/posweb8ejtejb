/**
 * Movimentacao.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package remote;

public class Movimentacao  implements java.io.Serializable {
    private remote.Cliente cliente;

    private int codigo;

    private java.util.Calendar data;

    private java.lang.String historico;

    private remote.Loja loja;

    private int ponto;

    private remote.Produto produto;

    private remote.TipoMovimentacao tipo;

    public Movimentacao() {
    }

    public Movimentacao(
           remote.Cliente cliente,
           int codigo,
           java.util.Calendar data,
           java.lang.String historico,
           remote.Loja loja,
           int ponto,
           remote.Produto produto,
           remote.TipoMovimentacao tipo) {
           this.cliente = cliente;
           this.codigo = codigo;
           this.data = data;
           this.historico = historico;
           this.loja = loja;
           this.ponto = ponto;
           this.produto = produto;
           this.tipo = tipo;
    }


    /**
     * Gets the cliente value for this Movimentacao.
     * 
     * @return cliente
     */
    public remote.Cliente getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this Movimentacao.
     * 
     * @param cliente
     */
    public void setCliente(remote.Cliente cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the codigo value for this Movimentacao.
     * 
     * @return codigo
     */
    public int getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this Movimentacao.
     * 
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the data value for this Movimentacao.
     * 
     * @return data
     */
    public java.util.Calendar getData() {
        return data;
    }


    /**
     * Sets the data value for this Movimentacao.
     * 
     * @param data
     */
    public void setData(java.util.Calendar data) {
        this.data = data;
    }


    /**
     * Gets the historico value for this Movimentacao.
     * 
     * @return historico
     */
    public java.lang.String getHistorico() {
        return historico;
    }


    /**
     * Sets the historico value for this Movimentacao.
     * 
     * @param historico
     */
    public void setHistorico(java.lang.String historico) {
        this.historico = historico;
    }


    /**
     * Gets the loja value for this Movimentacao.
     * 
     * @return loja
     */
    public remote.Loja getLoja() {
        return loja;
    }


    /**
     * Sets the loja value for this Movimentacao.
     * 
     * @param loja
     */
    public void setLoja(remote.Loja loja) {
        this.loja = loja;
    }


    /**
     * Gets the ponto value for this Movimentacao.
     * 
     * @return ponto
     */
    public int getPonto() {
        return ponto;
    }


    /**
     * Sets the ponto value for this Movimentacao.
     * 
     * @param ponto
     */
    public void setPonto(int ponto) {
        this.ponto = ponto;
    }


    /**
     * Gets the produto value for this Movimentacao.
     * 
     * @return produto
     */
    public remote.Produto getProduto() {
        return produto;
    }


    /**
     * Sets the produto value for this Movimentacao.
     * 
     * @param produto
     */
    public void setProduto(remote.Produto produto) {
        this.produto = produto;
    }


    /**
     * Gets the tipo value for this Movimentacao.
     * 
     * @return tipo
     */
    public remote.TipoMovimentacao getTipo() {
        return tipo;
    }


    /**
     * Sets the tipo value for this Movimentacao.
     * 
     * @param tipo
     */
    public void setTipo(remote.TipoMovimentacao tipo) {
        this.tipo = tipo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Movimentacao)) return false;
        Movimentacao other = (Movimentacao) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            this.codigo == other.getCodigo() &&
            ((this.data==null && other.getData()==null) || 
             (this.data!=null &&
              this.data.equals(other.getData()))) &&
            ((this.historico==null && other.getHistorico()==null) || 
             (this.historico!=null &&
              this.historico.equals(other.getHistorico()))) &&
            ((this.loja==null && other.getLoja()==null) || 
             (this.loja!=null &&
              this.loja.equals(other.getLoja()))) &&
            this.ponto == other.getPonto() &&
            ((this.produto==null && other.getProduto()==null) || 
             (this.produto!=null &&
              this.produto.equals(other.getProduto()))) &&
            ((this.tipo==null && other.getTipo()==null) || 
             (this.tipo!=null &&
              this.tipo.equals(other.getTipo())));
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
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        _hashCode += getCodigo();
        if (getData() != null) {
            _hashCode += getData().hashCode();
        }
        if (getHistorico() != null) {
            _hashCode += getHistorico().hashCode();
        }
        if (getLoja() != null) {
            _hashCode += getLoja().hashCode();
        }
        _hashCode += getPonto();
        if (getProduto() != null) {
            _hashCode += getProduto().hashCode();
        }
        if (getTipo() != null) {
            _hashCode += getTipo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Movimentacao.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://controle/", "movimentacao"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://controle/", "cliente"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("data");
        elemField.setXmlName(new javax.xml.namespace.QName("", "data"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("historico");
        elemField.setXmlName(new javax.xml.namespace.QName("", "historico"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("loja");
        elemField.setXmlName(new javax.xml.namespace.QName("", "loja"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://controle/", "loja"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ponto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ponto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("produto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "produto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://controle/", "produto"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://controle/", "tipoMovimentacao"));
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
