package com.victorcazorla.billing.service;

import com.victorcazorla.billing.model.Invoice;
import com.victorcazorla.billing.model.InvoiceLine;
import com.victorcazorla.billing.model.Product;
import com.victorcazorla.billing.repository.InvoiceLineRepository;
import com.victorcazorla.billing.repository.InvoiceRepository;
import com.victorcazorla.billing.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceLineService {

    @Autowired
    private InvoiceLineRepository invoiceLineRepository;

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<InvoiceLine> findAll() {
        return invoiceLineRepository.findAll();
    }

    public Optional<InvoiceLine> findById(Long id) {
        return invoiceLineRepository.findById(id);
    }

    public InvoiceLine create(Long invoiceId, Long productId, int quantity, double unitPrice) {
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        InvoiceLine line = new InvoiceLine(invoice, product, quantity, unitPrice);
        return invoiceLineRepository.save(line);
    }

    public InvoiceLine update(Long id, int quantity, double unitPrice) {
        InvoiceLine line = invoiceLineRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("InvoiceLine not found"));

        line.setQuantity(quantity);
        line.setUnitPrice(unitPrice);
        return invoiceLineRepository.save(line);
    }

    public void delete(Long id) {
        invoiceLineRepository.deleteById(id);
    }

    public List<InvoiceLine> getByInvoiceId(Long invoiceId) {
        return invoiceLineRepository.findByInvoiceId(invoiceId);
    }

    public List<InvoiceLine> getByProductId(Long productId) {
        return invoiceLineRepository.findByProductId(productId);
    }
}
