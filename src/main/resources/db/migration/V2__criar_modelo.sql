CREATE TABLE TBL_MODELO (
    ID_MODELO   SERIAL PRIMARY KEY,
    TX_NOME     VARCHAR(50) NOT NULL,
    NR_POTENCIA NUMERIC(10, 1),
    ID_MARCA    INTEGER     NOT NULL,
    FOREIGN KEY (ID_MARCA) REFERENCES TBL_MARCA (ID_MARCA)
);