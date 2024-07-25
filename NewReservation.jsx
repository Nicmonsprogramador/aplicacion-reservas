// src/components/NewReservation.jsx
import React, { useState } from 'react';
import axios from 'axios';

const NewReservation = () => {
  const [formData, setFormData] = useState({
    name: '',
    date: '',
    service: ''
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    axios.post('/api/reservations', formData)
      .then(response => alert('Reservation made successfully!'))
      .catch(error => console.error('There was an error making the reservation!', error));
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>New Reservation</h2>
      <label>
        Name:
        <input type="text" name="name" value={formData.name} onChange={handleChange} required />
      </label>
      <label>
        Date:
        <input type="date" name="date" value={formData.date} onChange={handleChange} required />
      </label>
      <label>
        Service:
        <input type="text" name="service" value={formData.service} onChange={handleChange} required />
      </label>
      <button type="submit">Make Reservation</button>
    </form>
  );
};

export default NewReservation;
