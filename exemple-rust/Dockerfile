FROM rust:1.82.0-slim-bullseye

WORKDIR /app

COPY . .
RUN cargo build --release
RUN cp ./target/release/exemple /bin/exemple

CMD ["/bin/exemple"]
