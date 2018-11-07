import { Observable, fromEvent, SchedulerLike } from 'rxjs';

class MyScheduler implements SchedulerLike {

}

function greeter(person: string) {
    return 'Hello, ' + person;
}

function setUpEvent() {
    const document1 = fromEvent(document.querySelector('#button1'), 'click');
    document1.subscribe(x => console.log(`clicked: ${x}`));


}

setUpEvent();
