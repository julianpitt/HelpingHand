<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Action extends Model
{
    public function datatype() {
        return $this->belongsTo('App\Models\DataType', 'data_type_id', 'id');
    }
    public function pledges() {
        return $this->hasMany('Pledges');
    }
}
