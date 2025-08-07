#![allow(dead_code, unused)]

#[derive(Clone, Default, Debug, PartialEq)]
pub struct Book {
    pub title: String,
    pub author: String,
    pub is_avaliable: bool,
}

impl Book {
    pub fn new(title: &str, author: &str) -> Self {
        Self {
            title: title.to_string(),
            author: author.to_string(),
            is_avaliable: true,
        }
    }
}
