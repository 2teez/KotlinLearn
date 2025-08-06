package com.prac.practoop

data class Book(val title: String, val author: String, var isAvaliable: Boolean = true)

data class BirthDate(val month: Int = 1, val day: Int = 1, val year: Int = 1970) {
    override fun toString() = "$month/$day/$year"
}

open class Person(var firstName: String, var lastName: String = "", val birthDate: BirthDate) {
    val name: String
        get() = "$firstName, $lastName"
}

class Member(firstName: String, lastName: String) : Person(firstName, lastName, BirthDate()) {
    val books: MutableList<Book> = mutableListOf()
    constructor(name: Pair<String, String>) : this(name.first, name.second)
    constructor(name: String) : this(firstName = "", lastName = "") {
        if (name.contains(' ')) {
            val (first, last) = name.split(' ')
            this.firstName = first
            this.lastName = last
        } else {
            this.firstName = name
        }
    }

    override fun toString() = "Member[$firstName, $lastName]"
}

class Library(val books: MutableList<Book> = mutableListOf()) {
    val members: MutableList<Member> = mutableListOf()

    fun addMember(member: Member) {
        members.add(member)
    }

    fun memberFind(name: String): Member {
        var pick: Member = Member(name)
        for (member in members) {
            if (name.equals(member.toString())) {
                pick = member
            }
        }
        return pick
    }

    fun borrowBook(bookToBorrow: Book, member: Member) {
        val book =
                books.find {
                    it.isAvaliable &&
                            it.title == bookToBorrow.title &&
                            it.author == bookToBorrow.author
                }
        if (book != null) {
            book.isAvaliable = false
            member.books.add(book)
        } else {
            println("$bookToBorrow is NOT AVAILABLE!")
        }
    }

    fun returnBook(bookReturned: Book, member: Member) {
        val book =
                books.find {
                    it.title == bookReturned.title &&
                            it.author == bookReturned.author &&
                            !it.isAvaliable
                }
        if (book != null) {
            book.isAvaliable = true
            member.books.remove(book)
        }
    }

    fun allBorrowedBook(): List<Book> = members.flatMap { it.books }

    fun addBook(title: String, author: String) = books.add(Book(title, author, true))

    fun listBooks() =
            println("\n\nAVALIABLE BOOKS:\n${books.filter { it.isAvaliable }.joinToString("\n")}")
}

fun main() {
    val lib = Library()
    lib.addBook("bible", "gideon")
    lib.addBook("prayer that moves mountains", "robert lensay")
    lib.addBook("god's general", "robert linsay")
    lib.addBook("new general mathematics", "cn port")

    lib.members.addAll(
            mutableListOf(
                    Member("John Doe"),
                    Member("dorcas" to "folorunso"),
                    Member("Albert" to "Esentin")
            )
    )

    val member = lib.memberFind("dorcas folorunso")

    lib.borrowBook(Book("bible", "gideon"), member)
    lib.borrowBook(Book("new general mathematics", "cn port"), member)
    lib.listBooks()
    lib.returnBook(Book("bible", "gideon"), member)
    lib.listBooks()
    lib.borrowBook(Book("new general mathematics", "cn port"), member)
    print(lib.allBorrowedBook())
}
