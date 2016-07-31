<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;

class DataType extends Model
{
    public function action() {
        return $this->hasMany('Action');
    }
}
