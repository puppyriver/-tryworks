import ReactDOM from 'react-dom';
import React from 'react';
import XTable from '../component/XTable.jsx';
import { Button } from 'react-bootstrap';
import { Table } from 'react-bootstrap';

ReactDOM.render(<div>

    <XTable ajaxMethod="ajax/queryAllEms"></XTable>
    </div>


    ,document.getElementById('react-content'));