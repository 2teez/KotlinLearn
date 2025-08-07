#![allow(dead_code, unused)]

use ::bk_lib::book::Book;
use ::bk_lib::library::Library;
use bk_lib::member::Member;
use cin::cin::cin;

fn main() {
    let mut lib = Library::new();

    let number_of_books = cin("Enter number of books to add: ");
    for _ in 0..=number_of_books {
        let book = get_a_book();
        lib.add_a_book(&book.title, &book.author);
    }

    let mut ae = Member::new_member("Albert", "Estein");
    let mut hf = Member::new_member_name("Henry Ford");
    let mut isn = Member::new_member("Isaac", "Newton");
    // add members
    lib.add_member(ae.clone());
    lib.add_member(hf.clone());
    lib.add_member(isn.clone());
    //
    lib.list_books();
    // borrow a book
    lib.borrow_book(Book::new("bible", "kjv"), &mut hf);
    lib.list_books();
    lib.return_book(Book::new("bible", "kjv"), &mut hf);
    lib.list_books();
}

fn get_a_book() -> Book {
    let title = cin("Get Book title: ");
    let author = cin("Book Author: ");
    Book {
        title,
        author,
        is_avaliable: true,
    }
}
