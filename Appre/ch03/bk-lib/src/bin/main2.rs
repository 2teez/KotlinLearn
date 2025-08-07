#![allow(dead_code, unused)]

use ::bk_lib::book::Book;
use ::bk_lib::library::Library;
use bk_lib::member::Member;

fn main() {
    ///
    let mut lib = Library::new();
    lib.add_book("bible", "gideon");
    lib.add_book("prayer that moves mountains", "robert lensay");
    lib.add_book("god's general", "robert linsay");
    lib.add_book("new general mathematics", "cn port");

    // add members
    lib.add_member(Member::new_member_name("John Doe"));
    lib.add_member(Member::new_member_name("dorcas folorunso"));
    lib.add_member(Member::new_member("Albert", "Esentin"));
    //println!("{:?}", lib);
    //
    let mut member = if let Some(member) = lib.find_member("dorcas folorunso") {
        (*member).clone()
    } else {
        Member::new()
    };
    //
    if member.person.first_name == "" && member.person.last_name == "" {
        println!("{:?} is not a member YET!", member);
        std::process::exit(1)
    }
    //
    lib.borrow_book(Book::new("bible", "gideon"), &mut member);
    lib.borrow_book(Book::new("new general mathematics", "cn port"), &mut member);
    //
    lib.list_books();
    lib.return_book(Book::new("new general mathematics", "cn port"), &mut member);
    //
    lib.list_books();
}
