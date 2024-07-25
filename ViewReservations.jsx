// src/components/ViewReservations.jsx
import React, { useState, useEffect } from 'react';
import axios from 'axios';

const ViewReservations = () => {
  const [reservations, setReservations] = useState([]);
  const [filters, setFilters] = useState({
    date: '',
    service: '',
    customer: ''
  });

  useEffect(() => {
    axios.get('/api/reservations')
      .then(response => setReservations(response.data))
      .catch(error => console.error('There was an error fetching the reservations!', error));
  }, []);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFilters({ ...filters, [name]: value });
  };

  const filteredReservations = reservations.filter(reservation => {
    return (!filters.date || reservation.date.includes(filters.date)) &&
           (!filters.service || reservation.service.includes(filters.service)) &&
           (!filters.customer || reservation.customer.includes(filters.customer));
  });

  return (
    <div>
      <h2>View Reservations</h2>
      <div>
        <label>
          Date:
          <input type="date" name="date" value={filters.date} onChange={handleChange} />
        </label>
        <label>
          Service:
          <input type="text" name="service" value={filters.service} onChange={handleChange} />
        </label>
        <label>
          Customer:
          <input type="text" name="customer" value={filters.customer} onChange={handleChange} />
        </label>
      </div>
      <ul>
        {filteredReservations.map(reservation => (
          <li key={reservation.id}>
            {reservation.name} - {reservation.date} - {reservation.service}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default ViewReservations;
