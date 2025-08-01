#![allow(dead_code, unused)]

use std::collections::HashMap;
use std::fmt::Debug;

trait Printer {
    fn prints(&self)
    where
        Self: std::fmt::Debug,
    {
        println!("{:?}", self);
    }
}

impl<T: Debug> Printer for T {}

#[derive(Debug)]
struct Person<'a> {
    age: u8,
    name: &'a str,
}

fn main() {
    let age: u8 = 34;
    age.prints();
    "timothy".to_owned().prints();

    let p = Person {
        name: "john-doe",
        age: 23,
    };
    p.prints();

    [5, 9, 2, 0].prints();
    let mut hash = HashMap::<&str, u32>::new();
    hash.insert("tom", 23);
    hash.prints();
}
