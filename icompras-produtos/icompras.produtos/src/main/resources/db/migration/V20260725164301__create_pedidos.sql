CREATE TABLE pedido (
    codigo BIGSERIAL PRIMARY KEY,
    codigo_cliente BIGINT NOT NULL,
    data_pedido TIMESTAMP NOT NULL DEFAULT NOW(),
    chave_pagamento TEXT,
    observacoes TEXT,
    status VARCHAR(20) CHECK (
        status IN (
            'REALIZADO',
            'PAGO',
            'FATURADO',
            'ENVIADO',
            'ERRO_PAGAMENTO',
            'PREPARANDO_ENVIO'
        )
    ),
    total DECIMAL(16,2) NOT NULL,
    codigo_rastreio VARCHAR(255),
    url_nf TEXT
);