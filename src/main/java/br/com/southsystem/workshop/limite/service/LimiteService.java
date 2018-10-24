package br.com.southsystem.workshop.limite.service;

import br.com.southsystem.workshop.limite.broker.BrokerInput;
import br.com.southsystem.workshop.contacorrente.model.Conta;
import br.com.southsystem.workshop.limite.model.Limite;
import br.com.southsystem.workshop.limite.repository.LimiteRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class LimiteService {
    private final LimiteRepository limiteRepository;
    private final BigDecimal limiteCredito;

    public LimiteService(LimiteRepository limiteRepository, @Value("${limite.credito}") BigDecimal limiteCredito) {
        this.limiteRepository = limiteRepository;
        this.limiteCredito = limiteCredito;
    }

    @StreamListener(target = BrokerInput.CONTA_CORRENTE_CRIADA)
    public void contaCorrenteCriada(Conta conta) {
        Limite limite = new Limite();
        limite.setContaId(conta.getId());
        limite.setLimite(limiteCredito);
        limiteRepository.save(limite);
    }
}
