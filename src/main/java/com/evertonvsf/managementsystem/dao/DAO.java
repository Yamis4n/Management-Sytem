package com.evertonvsf.managementsystem.dao;

import com.evertonvsf.managementsystem.dao.money.invoice.InvoiceCRUD;
import com.evertonvsf.managementsystem.dao.money.invoice.InvoiceListImpl;
import com.evertonvsf.managementsystem.dao.money.payment.PaymentCRUD;
import com.evertonvsf.managementsystem.dao.money.payment.PaymentListImpl;
import com.evertonvsf.managementsystem.dao.stock.buyorder.BuyOrderCRUD;
import com.evertonvsf.managementsystem.dao.stock.buyorder.BuyOrderListImpl;
import com.evertonvsf.managementsystem.dao.stock.component.ComponentCRUD;
import com.evertonvsf.managementsystem.dao.stock.component.ComponentListImpl;
import com.evertonvsf.managementsystem.dao.task.service.ServiceCRUD;
import com.evertonvsf.managementsystem.dao.task.service.ServiceListImpl;
import com.evertonvsf.managementsystem.dao.task.serviceorder.ServiceOrderCRUD;
import com.evertonvsf.managementsystem.dao.task.serviceorder.ServiceOrderListImpl;
import com.evertonvsf.managementsystem.dao.users.client.ClientCRUD;
import com.evertonvsf.managementsystem.dao.users.client.ClientListImpl;
import com.evertonvsf.managementsystem.dao.users.technician.TechnicianCRUD;
import com.evertonvsf.managementsystem.dao.users.technician.TechnicianListImpl;

public class DAO {
    private static InvoiceCRUD invoiceDAO;
    private static PaymentCRUD paymentDAO;
    private static BuyOrderCRUD buyOrderDAO;
    private static ComponentCRUD componentDAO;
    private static ServiceCRUD serviceDao;
    private static ServiceOrderCRUD serviceOrderDAO;
    private static ClientCRUD clientDAO;
    private static TechnicianCRUD technicianDAO;


    public static InvoiceCRUD getInvoiceDAO() {
        if (invoiceDAO == null){
            invoiceDAO = new InvoiceListImpl();
        }
        return invoiceDAO;
    }

    public static PaymentCRUD getPaymentDAO() {
        if (paymentDAO == null){
            paymentDAO = new PaymentListImpl();
        }
        return paymentDAO;
    }

    public static BuyOrderCRUD getBuyOrderDAO() {
        if (buyOrderDAO == null){
            buyOrderDAO = new BuyOrderListImpl();
        }
        return buyOrderDAO;
    }

    public static ComponentCRUD getComponentDAO() {
        if (componentDAO == null){
            componentDAO = new ComponentListImpl();
        }
        return componentDAO;
    }

    public static ServiceCRUD getServiceDao() {
        if (serviceDao == null){
            serviceDao = new ServiceListImpl();
        }
        return serviceDao;
    }

    public static ServiceOrderCRUD getServiceOrderDAO() {
        if (serviceOrderDAO == null){
            serviceOrderDAO = new ServiceOrderListImpl();
        }
        return serviceOrderDAO;
    }

    public static ClientCRUD getClientDAO() {
        if (clientDAO == null){
            clientDAO = new ClientListImpl();
        }
        return clientDAO;
    }

    public static TechnicianCRUD getTechnicianDAO() {
        if (technicianDAO == null){
            technicianDAO = new TechnicianListImpl();
        }
        return technicianDAO;
    }
}
