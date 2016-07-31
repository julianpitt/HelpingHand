<?php

use App\Models\DataType;
use Illuminate\Database\Seeder;

class DataTypeSeeder extends Seeder
{
    /**
     * Run the database seeds.
     *
     * @return void
     */
    public function run()
    {
        $types = [
            'water',
            'gas',
            'electricity',
            'homelessness'
        ];

        foreach($types as $type) {
            $patient = new DataType();
            $patient->name = $type;
            $patient->url = 'http://';
            $patient->save();
        }
    }
}
