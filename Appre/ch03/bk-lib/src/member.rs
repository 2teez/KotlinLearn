#![allow(dead_code, unused)]

use crate::book::Book;

#[derive(Clone, Default, Debug, PartialEq)]
struct BirthDate {
    month: u8,
    day: u8,
    year: u8,
}

#[derive(Clone, Default, Debug, PartialEq)]
pub struct Person {
    first_name: String,
    last_name: String,
    birth_day: BirthDate,
}

#[derive(Clone, Default, Debug, PartialEq)]
pub struct Member {
    pub person: Person,
    pub books: Vec<Book>,
}

impl Member {
    pub fn new() -> Self {
        Self {
            person: Person::default(),
            books: Vec::<Book>::new(),
        }
    }

    pub fn new_member<'a>(first_name: &'a str, last_name: &'a str) -> Self {
        Self {
            person: Person {
                first_name: first_name.to_string(),
                last_name: last_name.to_string(),
                birth_day: BirthDate::default(),
            },
            books: Vec::<Book>::new(),
        }
    }

    pub fn new_member_name(name: &str) -> Self {
        let trimmed = name.trim();
        let names = trimmed.split_whitespace().collect::<Vec<_>>();
        let last_name = if names.len() == 1 {
            String::new()
        } else {
            names[1].to_string()
        };
        Self {
            person: Person {
                first_name: names[0].to_string(),
                last_name: last_name,
                birth_day: BirthDate::default(),
            },
            books: Vec::<Book>::new(),
        }
    }
}
