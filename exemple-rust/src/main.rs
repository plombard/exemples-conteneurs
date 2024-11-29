use std::{
    io::{prelude::*},
    net::{TcpListener, TcpStream},
};
use chrono::Local;

fn main() {
    let listener = TcpListener::bind("0.0.0.0:8081").unwrap();

    println!("Listening on port 8081");
    for stream in listener.incoming() {
        let stream = stream.unwrap();

        handle_connection(stream);
    }
}

fn handle_connection(mut stream: TcpStream) {
    let date = Local::now();
    println!("{} Invocation de Hello", date.format("%Y-%m-%d][%H:%M:%S"));
    let status_line = "HTTP/1.1 200 OK";
    let contents = "Hello World from rust\r\n";
    let length = contents.len();

    let response =
        format!("{status_line}\r\nContent-Length: {length}\r\n\r\n{contents}");

    stream.write_all(response.as_bytes()).unwrap();
}
