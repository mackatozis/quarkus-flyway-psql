-- ****************************************************************************
-- CREATE CATEGORY TABLE
-- ****************************************************************************
CREATE TABLE IF NOT EXISTS quarkus_test.category
(
  id                      UUID NOT NULL,
  "name"                  TEXT NOT NULL,
  description             TEXT NOT NULL,
  CONSTRAINT category_pk PRIMARY KEY (id)
);

-- ****************************************************************************
-- CREATE FRUIT TABLE
-- ****************************************************************************
CREATE TABLE IF NOT EXISTS quarkus_test.fruit
(
    id                      UUID NOT NULL,
    "name"                  TEXT NOT NULL,
    category_id             UUID NOT NULL,
    CONSTRAINT fruit_pk PRIMARY KEY (id)
);