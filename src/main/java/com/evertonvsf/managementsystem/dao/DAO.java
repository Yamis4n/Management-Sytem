package com.evertonvsf.managementsystem.dao;

import com.evertonvsf.managementsystem.dao.crud.money.invoice.InvoiceCRUD;
import com.evertonvsf.managementsystem.dao.crud.money.invoice.InvoiceListImpl;
import com.evertonvsf.managementsystem.dao.crud.money.payment.PaymentCRUD;
import com.evertonvsf.managementsystem.dao.crud.money.payment.PaymentListImpl;
import com.evertonvsf.managementsystem.dao.crud.stock.buyorder.BuyOrderCRUD;
import com.evertonvsf.managementsystem.dao.crud.stock.buyorder.BuyOrderListImpl;
import com.evertonvsf.managementsystem.dao.crud.stock.component.ComponentCRUD;
import com.evertonvsf.managementsystem.dao.crud.stock.component.ComponentListImpl;
import com.evertonvsf.managementsystem.dao.crud.task.service.ServiceCRUD;
import com.evertonvsf.managementsystem.dao.crud.task.service.ServiceListImpl;
import com.evertonvsf.managementsystem.dao.crud.task.serviceorder.ServiceOrderCRUD;
import com.evertonvsf.managementsystem.dao.crud.task.serviceorder.ServiceOrderListImpl;
import com.evertonvsf.managementsystem.dao.crud.users.client.ClientCRUD;
import com.evertonvsf.managementsystem.dao.crud.users.client.ClientListImpl;
import com.evertonvsf.managementsystem.dao.crud.users.technician.TechnicianCRUD;
import com.evertonvsf.managementsystem.dao.crud.users.technician.TechnicianListImpl;

public class DAO {
    private static InvoiceCRUD invoiceDAO;
    private static PaymentCRUD paymentDAO;
    private static BuyOrderCRUD buyOrderDAO;
    private static ComponentCRUD componentDAO;
    private static ServiceCRUD serviceDao;
    private static ServiceOrderCRUD serviceOrderDAO;
    private static ClientCRUD clientDAO;
    private static TechnicianCRUD technicianDAO;


    public static InvoiceCRUD fromInvoice() {
        if (invoiceDAO == null){
            invoiceDAO = new InvoiceListImpl();
        }
        return invoiceDAO;
    }

    public static PaymentCRUD fromPayment() {
        if (paymentDAO == null){
            paymentDAO = new PaymentListImpl();
        }
        return paymentDAO;
    }

    public static BuyOrderCRUD fromBuyOrder() {
        if (buyOrderDAO == null){
            buyOrderDAO = new BuyOrderListImpl();
        }
        return buyOrderDAO;
    }

    public static ComponentCRUD fromComponent() {
        if (componentDAO == null){
            componentDAO = new ComponentListImpl();
        }
        return componentDAO;
    }

    public static ServiceCRUD fromService() {
        if (serviceDao == null){
            serviceDao = new ServiceListImpl();
        }
        return serviceDao;
    }

    public static ServiceOrderCRUD fromServiceOrder() {
        if (serviceOrderDAO == null){
            serviceOrderDAO = new ServiceOrderListImpl();
        }
        return serviceOrderDAO;
    }

    public static ClientCRUD fromClient() {
        if (clientDAO == null){
            clientDAO = new ClientListImpl();
        }
        return clientDAO;
    }

    public static TechnicianCRUD fromTechnician() {
        if (DAO.technicianDAO == null){
            DAO.technicianDAO = new TechnicianListImpl();
        }
        return technicianDAO;
    }
}
