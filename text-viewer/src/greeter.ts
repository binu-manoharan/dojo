interface Person {
    firstName: string,
    lastName: string
}

class Student {
    fullName: string;

    public constructor(
        public firstName: string,
        public middleName: string,
        public lastName: string
    ) { }
}

function greeter(person: Person) {
    return `Hello ${person.firstName} ${person.lastName}`;
}

const user = new Student('Binu', 'P', 'Manoharan');
document.body.innerText = greeter(user);