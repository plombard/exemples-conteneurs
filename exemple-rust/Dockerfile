FROM rust:1.82.0-slim-bullseye

WORKDIR /app

COPY MAIS_QUOI .
RUN cargo build --release
RUN cp ./target/release/exemple /bin/exemple

CMD ["QUELLE_COMMANDE_METTRE_ICI"]
