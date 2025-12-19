CREATE TABLE ninja (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    vila VARCHAR(100) NOT NULL,
    idade INT NOT NULL CHECK (idade >= 0),
    chakra INT NOT NULL CHECK (chakra >= 0 AND chakra <= 100),
    criado_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE jutsu (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    dano INT NOT NULL CHECK (dano >= 0),
    consumo_chakra INT NOT NULL CHECK (consumo_chakra >= 0),
    criado_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE ninja_jutsu (
    ninja_id BIGINT NOT NULL,
    jutsu_id BIGINT NOT NULL,

    CONSTRAINT pk_ninja_jutsu PRIMARY KEY (ninja_id, jutsu_id),

    CONSTRAINT fk_ninja
        FOREIGN KEY (ninja_id)
        REFERENCES ninja (id),

    CONSTRAINT fk_jutsu
        FOREIGN KEY (jutsu_id)
        REFERENCES jutsu (id)
);
