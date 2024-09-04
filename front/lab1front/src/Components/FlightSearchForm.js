import React, { useState } from 'react';
import axios from 'axios';
import './FlightSearchForm.css';

function FlightSearchForm() {
    const [flights, setFlights] = useState([]);
    const [filters, setFilters] = useState({
        startDate: '',
        endDate: '',
        origin: '',
        destination: '',
        maxPrice: '',
        category: '',
        baggage: ''
    });

    const handleChange = (e) => {
        setFilters({
            ...filters,
            [e.target.name]: e.target.value
        });
    };

    const handleSearch = () => {
        // Validación de campos obligatorios
        if (!filters.startDate || !filters.endDate || !filters.origin || !filters.destination) {
            alert('Please fill out all required fields: Start Date, End Date, Origin, and Destination.');
            return;
        }

        axios.get('http://localhost:8081/api/flights/search', {
            params: {
                startDate: filters.startDate,
                endDate: filters.endDate,
                origin: filters.origin,
                destination: filters.destination,
                maxPrice: filters.maxPrice,
                baggage: filters.baggage,
                category: filters.category
            }
        })
            .then(response => {
                setFlights(response.data);
            })
            .catch(error => {
                console.error('Error fetching flights:', error);
            });
    };

    return (
        <div className="container">
            <h1>Flight Search</h1>
            <p className="required-info">Fields marked with <span className="required-asterisk">*</span> are required.</p>
            <form>
                <div>
                    <label>Start Date:<span className="required-asterisk">*</span></label>
                    <input type="date" name="startDate" value={filters.startDate} onChange={handleChange} required />
                </div>
                <div>
                    <label>End Date:<span className="required-asterisk">*</span></label>
                    <input type="date" name="endDate" value={filters.endDate} onChange={handleChange} required />
                </div>
                <div>
                    <label>Origin:<span className="required-asterisk">*</span></label>
                    <input type="text" name="origin" placeholder="Type the origin" value={filters.origin} onChange={handleChange} required />
                </div>
                <div>
                    <label>Destination:<span className="required-asterisk">*</span></label>
                    <input type="text" name="destination" placeholder="Type the Destination" value={filters.destination} onChange={handleChange} required />
                </div>
                <div>
                    <label>Max Price:</label>
                    <input type="number" name="maxPrice" placeholder="Enter the flight price" value={filters.maxPrice} onChange={handleChange} />
                </div>
                <div>
                    <label>Baggage Type:</label>
                    <select name="baggage" value={filters.baggage} onChange={handleChange}>
                        <option value="">None</option>
                        <option value="Carry-on">Carry-on</option>
                        <option value="Checked">Checked</option>
                    </select>
                </div>

                <div>
                    <label>Travel Class:</label>
                    <select name="category" value={filters.category} onChange={handleChange}>
                        <option value="">None</option>
                        <option value="Business">Business</option>
                        <option value="Economy">Economy</option>
                    </select>
                </div>
                <button type="button" onClick={handleSearch}>Search Flights</button>
            </form>

            <h2>Available Flights</h2>
            <table>
                <thead>
                <tr>
                    <th>Flight ID</th>
                    <th>Origin</th>
                    <th>Destination</th>
                    <th>Date</th>
                    <th>Price</th>
                    <th>Baggage Type</th>
                    <th>Travel Class</th>
                </tr>
                </thead>
                <tbody>
                {flights.length > 0 ? flights.map(flight => (
                    <tr key={flight.id}>
                        <td>{flight.id}</td>
                        <td>{flight.origin}</td>
                        <td>{flight.destination}</td>
                        <td>{flight.date}</td>
                        <td>{flight.price}</td>
                        <td>{flight.baggage}</td>
                        <td>{flight.category}</td>
                    </tr>
                )) : (
                    <tr>
                        <td colSpan="7">No flights available for the selected filters.</td>
                    </tr>
                )}
                </tbody>
            </table>
        </div>
    );
}

export default FlightSearchForm;
