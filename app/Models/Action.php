<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class Action extends Model
{
    public function DataType() {
        return $this->belongsTo('Datatype');
    }
    public function pledges() {
        return $this->hasMany('Pledges');
    }
}
