package com.victorcazorla.billing.controller;

import com.victorcazorla.billing.model.InvoiceLine;
import com.victorcazorla.billing.service.InvoiceLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice-lines")
public class InvoiceLineController {

    @Autowired
    private InvoiceLineService invoiceLineService;

    @PostMapping
    public ResponseEntity<InvoiceLine> create(@RequestParam Long invoiceId,
                                              @RequestParam Long productId,
                                              @RequestParam int quantity,
                                              @RequestParam double unitPrice) {
        InvoiceLine line = invoiceLineService.create(invoiceId, productId, quantity, unitPrice);
        return ResponseEntity.ok(line);
    }

    @GetMapping
    public ResponseEntity<List<InvoiceLine>> getAll() {
        return ResponseEntity.ok(invoiceLineService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceLine> getById(@PathVariable Long id) {
        return invoiceLineService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-invoice/{invoiceId}")
    public ResponseEntity<List<InvoiceLine>> getByInvoiceId(@PathVariable Long invoiceId) {
        return ResponseEntity.ok(invoiceLineService.getByInvoiceId(invoiceId));
    }

    @GetMapping("/by-product/{productId}")
    public ResponseEntity<List<InvoiceLine>> getByProductId(@PathVariable Long productId) {
        return ResponseEntity.ok(invoiceLineService.getByProductId(productId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceLine> update(@PathVariable Long id,
                                              @RequestParam int quantity,
                                              @RequestParam double unitPrice) {
        return ResponseEntity.ok(invoiceLineService.update(id, quantity, unitPrice));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        invoiceLineService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
