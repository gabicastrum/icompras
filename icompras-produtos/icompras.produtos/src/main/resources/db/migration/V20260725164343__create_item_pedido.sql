CREATE TABLE item_pedido (
    codigo BIGSERIAL PRIMARY KEY,
    codigo_pedido BIGINT NOT NULL REFERENCES pedido(codigo),
    codigo_produto BIGINT NOT NULL,
    quantidade INT NOT NULL,
    valor_unitario DECIMAL(16,2) NOT NULL
);