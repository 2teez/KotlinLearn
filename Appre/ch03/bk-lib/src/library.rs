#![allow(dead_code, unused)]

use crate::book::Book;
use crate::member::Member;

#[derive(Debug, Clone)]
pub struct Library {
    pub books: Vec<Book>,
    pub members: Vec<Member>,
}

impl Library {
    pub fn new() -> Self {
        Self {
            books: Vec::<Book>::new(),
            members: Vec::<Member>::new(),
        }
    }

    pub fn add_member(&mut self, member: Member) {
        self.members.push(member)
    }

    pub fn find_member(&self, name: &str) -> Option<Member> {
        let pick = Member::new_member_name(name);
        for member in &self.members {
            if pick == *member {
                return Some(pick);
            }
        }
        None
    }

    pub fn add_a_book(&mut self, title: &str, author: &str) {
        self.books.push(Book {
            title: title.to_string(),
            author: author.to_string(),
            is_avaliable: true,
        });
    }

    pub fn borrow_book(&mut self, book_to_borrow: Book, member: &mut Member) -> bool {
        for book in &mut self.books {
            if book.title == book_to_borrow.title
                && book.author == book_to_borrow.author
                && book.is_avaliable
            {
                member.books.push(book.clone());
                book.is_avaliable = false;
                return true;
            }
        }
        false
    }

    pub fn return_book(&mut self, book_to_return: Book, member: &mut Member) -> bool {
        for book in self.books.iter_mut() {
            if book.title == book_to_return.title && book.author == book_to_return.author {
                if !book.is_avaliable {
                    book.is_avaliable = true;

                    // Also remove from member.books
                    if let Some(pos) = member.books.iter().position(|b| {
                        b.title == book_to_return.title && b.author == book_to_return.author
                    }) {
                        member.books.remove(pos);
                    }

                    println!("Book returned: {:?}", book);
                    return true;
                }
            }
        }
        println!("Could not return book: {:?}", book_to_return);
        false
    }

    pub fn list_books(&self) {
        println!(
            "\n\nAVALIABLE BOOKS: {:?}",
            self.books
                .clone()
                .into_iter()
                .filter(|it| it.is_avaliable)
                .collect::<Vec<_>>()
        );
    }
}
