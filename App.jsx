// src/App.jsx
import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import NewReservation from './components/NewReservation';
import ModifyReservation from './components/ModifyReservation';
import CancelReservation from './components/CancelReservation';
import ViewReservations from './components/ViewReservations';

const App = () => {
  return (
    <Router>
      <div>
        <nav>
          <ul>
            <li><a href="/new">New Reservation</a></li>
            <li><a href="/reservations">View Reservations</a></li>
          </ul>
        </nav>
        <Switch>
          <Route path="/new" component={NewReservation} />
          <Route path="/modify/:id" component={ModifyReservation} />
          <Route path="/cancel/:id" component={CancelReservation} />
          <Route path="/reservations" component={ViewReservations} />
        </Switch>
      </div>
    </Router>
  );
};

export default App;
